package chamados.homeney.service;

import chamados.homeney.dto.request.RequestCalledDto;
import chamados.homeney.dto.response.ResponseCalledDto;
import chamados.homeney.entity.Called;
import chamados.homeney.enums.PriorityRole;
import chamados.homeney.enums.StatusRole;
import chamados.homeney.repository.CalledRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

        called.setPriority(PriorityRole.OPEN);
        called.setStatus(StatusRole.PENDING);
        return calledRepository.save(called);
    }

    public List<Called> listAllCalled (){
        return calledRepository.findAll();
    }

    public Called findCalled (Long id) throws Exception{
        return calledRepository.findById(id).orElseThrow(() -> new Exception("Chamado não encontrado"));
    }

    public Called takeCalled (Long id, ResponseCalledDto dto) throws Exception {
        Called called = findCalled(id);
        called.setPriority(dto.getPriority());
        called.setStatus(StatusRole.PROGRESS);
        return calledRepository.save(called);
    }

    public Called finishCalled (Long id) throws Exception {
        Called called = findCalled(id);
        if (called.getStatus() != StatusRole.PROGRESS){
            throw new Exception("Não é possivel concluir pois o chamado não foi aberto");
        }
        called.setStatus(StatusRole.COMPLETED);
        return calledRepository.save(called);
    }

    public Called cancelCalled (Long id) throws  Exception {
        Called called = findCalled(id);
        if (called.getStatus() != StatusRole.PROGRESS){
        throw  new Exception("Não é possivel cancelar o chamado pos ele não foi aberto");
        }
        called.setStatus(StatusRole.CANCEL);
        return calledRepository.save(called);
    }
}
