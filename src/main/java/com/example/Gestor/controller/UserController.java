package com.example.Gestor.controller;

import com.example.Gestor.model.User;
import com.example.Gestor.repository.UserRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;  // Inyecta el repositorio

    // Crear un usuario
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        user = userRepository.save(user); // Guarda el usuario en la base de datos
        return ResponseEntity.ok(user);
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Recupera todos los usuarios de la base de datos
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id) // Busca un usuario por ID
                .map(ResponseEntity::ok) // Si lo encuentra, lo devuelve
                .orElse(ResponseEntity.notFound().build()); // Si no lo encuentra, devuelve un 404
    }

    // PUT: Actualizar un usuario por ID
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User updatedUser) {
        return userRepository.findById(id) // Busca el usuario por ID
                .map(user -> {
                    user.setName(updatedUser.getName()); // Actualiza los campos
                    user.setEmail(updatedUser.getEmail());
                    userRepository.save(user); // Guarda los cambios en la base de datos
                    return ResponseEntity.ok(user);
                })
                .orElse(ResponseEntity.notFound().build()); // Si no lo encuentra, devuelve un 404
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) { // Verifica si el usuario existe
            userRepository.deleteById(id); // Elimina el usuario
            return ResponseEntity.noContent().build(); // Eliminación exitosa
        }
        return ResponseEntity.notFound().build(); // Si no lo encuentra, devuelve un 404
    }
}
