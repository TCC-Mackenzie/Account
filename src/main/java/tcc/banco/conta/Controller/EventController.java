package tcc.banco.conta.Controller;

import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    private EventStore eventStore;

    public EventController(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @GetMapping
    @RequestMapping(value = "/{aggregateCodigo}")
    @Transactional(readOnly = true)
    public List<EventMessage> listEvents(@PathVariable String aggregateCodigo) {
        return eventStore.readEvents(aggregateCodigo).asStream().collect(Collectors.toList());
    }
}
