package chamados.homeney.service;

import chamados.homeney.dto.request.RequestUserDto;
import chamados.homeney.entity.User;
import chamados.homeney.enums.UserRole;
import chamados.homeney.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser (RequestUserDto dto){
        User user = new User (
                dto.getNome(),
                dto.getSetor()
        );

        user.setRole(UserRole.USER);
        return userRepository.save(user);

    }
    public User createAtendent (RequestUserDto dto){
        User user = new User (
                dto.getNome(),
                dto.getSetor()
        );

        user.setRole(UserRole.ATTENDANT);
        return userRepository.save(user);
    }

    public User findOne (Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public List<User> findAll (){
        return userRepository.findAll();
    }

    public void delete (Long id){
        userRepository.deleteById(id);
    }











}
