package med.vol.api.repository;


import med.vol.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositpry extends JpaRepository<Usuario, Long> {

}
