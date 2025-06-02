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
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseListObjects;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;


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

    @Transactional(readOnly = true)
    public List<TicketDTO> getTicketData(Integer idTicket, LocalDate dateTicket, String status) {
        try {
            logger.info("Iniciando a consulta de tickets - idTicket: {}, dateTicket: {}, status: {}", idTicket, dateTicket, status);

            if (idTicket == null && dateTicket == null && (status == null || status.isEmpty())) {
                logger.warn("Parâmetros insuficientes para consulta: todos os filtros são nulos ou vazios");
            }

            List<Ticket> tickets = ticketRepository.executeTicketSelectSP(idTicket, dateTicket, status);


            if (tickets.isEmpty()) {
                logger.warn("Nenhum ticket encontrado para os parâmetros fornecidos - idTicket: {}, dateTicket: {}, status: {}", idTicket, dateTicket, status);
            } else {
                logger.info("Consulta de tickets realizada com sucesso. Total de tickets encontrados: {}", tickets.size());
            }

            return parseListObjects(tickets, TicketDTO.class);

        } catch (Exception e) {
            logger.error("Erro ao consultar tickets", e);
            throw new TicketServiceException("Falha na consulta de tickets", e);
        }
    }

    @Transactional
    public TicketDTO createTicket(CreateTicketDTO dto) {
        logger.info("Serviço: Tentando criar novo ticket com título: {}", dto.getNameTicket());

        User requester = userRepository.findById(Long.valueOf(dto.getRequesterId()))
                .orElseThrow(() -> new ResourceNotFoundException("Solicitante (User) não encontrado com ID: " + dto.getRequesterId()));

        Category category = categoryRepository.findById(Long.valueOf(dto.getCategoryId()))
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com ID: " + dto.getCategoryId()));

        if (dto.getSkillIds() != null && !dto.getSkillIds().isEmpty()) {
            logger.warn("Serviço: skillIds fornecidos no DTO, mas a entidade Ticket atual não possui campo para associar skills. As skills serão ignoradas nesta criação.");
        }

        Ticket newTicket = new Ticket();

        newTicket.setNameTicket(dto.getNameTicket());
        newTicket.setDescription(dto.getDescription());


        if (requester.getIdUser() != null) {
            newTicket.setIdUser(requester.getIdUser().intValue());
        }
        newTicket.setNameUser(requester.getNameUser());

        if (category.getIdCategory() != null) {
            newTicket.setIdCategory(category.getIdCategory().intValue());
        }
        newTicket.setNameCategory(category.getNameCategory());

        newTicket.setColdTicket(dto.getColdTicket());

        newTicket.setDateTicket(LocalDate.now());
        newTicket.setStatus("Aberto");

        Ticket savedTicket = ticketRepository.save(newTicket);
        logger.info("Serviço: Ticket criado com sucesso com ID: {}", savedTicket.getIdTicket());

        return parseObject(savedTicket, TicketDTO.class);
    }

    public SkillRepository getSkillRepository() {
        return skillRepository;
    }
}
