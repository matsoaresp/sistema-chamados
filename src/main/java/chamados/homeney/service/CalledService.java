package chamados.homeney.service;

import chamados.homeney.dto.request.RequestCalledDto;
import chamados.homeney.entity.Called;
import chamados.homeney.enums.StatusRole;
import chamados.homeney.repository.CalledRepository;
import org.springframework.stereotype.Service;

@Service
public class CalledService {

    private final CalledRepository calledRepository;


    public CalledService(CalledRepository calledRepository) {
        this.calledRepository = calledRepository;
    }

    public Called createCalled (RequestCalledDto dto){
        Called called = new Called (
                dto.getTitulo(),
                dto.getDescricao()
        );

        called.setStatus(StatusRole.PENDING);
        return calledRepository.save(called);
    }

}
