package br.com.TecHelpAPI.services;

import br.com.TecHelpAPI.data.dto.CreateTicketDTO;
import br.com.TecHelpAPI.data.dto.TicketDTO;
import br.com.TecHelpAPI.exception.ResourceNotFoundException;
import br.com.TecHelpAPI.exception.TicketServiceException;
import br.com.TecHelpAPI.model.Category;
import br.com.TecHelpAPI.model.Ticket;
import br.com.TecHelpAPI.model.User;
import br.com.TecHelpAPI.repository.CategoryRepository;
import br.com.TecHelpAPI.repository.SkillRepository;
import br.com.TecHelpAPI.repository.TicketRepository;
import br.com.TecHelpAPI.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static br.com.TecHelpAPI.mapper.ObjectMapper.parseListObjects;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseObject;

@Service
public class TicketServices {

    private static final Logger logger = LoggerFactory.getLogger(TicketServices.class);

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final SkillRepository skillRepository;

    @Autowired
    public TicketServices(TicketRepository ticketRepository,
                          UserRepository userRepository,
                          CategoryRepository categoryRepository,
                          SkillRepository skillRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.skillRepository = skillRepository;
    }

    // =========================
    // Consulta de tickets (via SP)
    // =========================
    @Transactional(readOnly = true)
    public List<TicketDTO> getTicketData(Integer idTicket, LocalDate dateTicket, String status) {
        try {
            logger.info("Iniciando consulta de tickets - idTicket: {}, dateTicket: {}, status: {}", idTicket, dateTicket, status);

            if (idTicket == null && dateTicket == null && (status == null || status.isEmpty())) {
                logger.warn("Parâmetros insuficientes: todos os filtros são nulos ou vazios");
            }

            List<Ticket> tickets = ticketRepository.executeTicketSelectSP(idTicket, dateTicket, status);

            if (tickets.isEmpty()) {
                logger.warn("Nenhum ticket encontrado para os parâmetros fornecidos");
            } else {
                logger.info("Consulta realizada com sucesso. Total de tickets encontrados: {}", tickets.size());
            }

            return parseListObjects(tickets, TicketDTO.class);

        } catch (Exception e) {
            logger.error("Erro ao consultar tickets", e);
            throw new TicketServiceException("Falha na consulta de tickets", e);
        }
    }

    // =========================
    // Criação de tickets (insert direto)
    // =========================
    @Transactional
    public TicketDTO createTicket(CreateTicketDTO dto) {
        logger.info("Serviço: Criando ticket com título: {}", dto.getNameTicket());

        LocalDate date = dto.getDateTicket() != null ? dto.getDateTicket() : LocalDate.now();
        String status = dto.getStatus() != null ? dto.getStatus() : "Aberto";

        // Valida usuário
        User requester = userRepository.findById(Long.valueOf(dto.getRequesterId()))
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Solicitante (User) não encontrado com ID: " + dto.getRequesterId()
                ));

        // Valida categoria
        Category category = categoryRepository.findById(Long.valueOf(dto.getCategoryId()))
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Categoria não encontrada com ID: " + dto.getCategoryId()
                ));

        // Chama SP de insert
        Ticket insertedTicket = ticketRepository.executeTicketInsertSP(
                dto.getNameTicket(),
                date,
                requester.getIdUser(),
                dto.getDescription(),
                category.getIdCategory(),
                status
        );

        logger.info("Ticket criado com sucesso com ID: {}", insertedTicket.getIdTicket());

        return parseObject(insertedTicket, TicketDTO.class);
    }
}
