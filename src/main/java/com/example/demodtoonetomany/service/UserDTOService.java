package com.example.demodtoonetomany.service;

import com.example.demodtoonetomany.dto.LocationDto;
import com.example.demodtoonetomany.dto.UserDTO;
import com.example.demodtoonetomany.entity.Location;
import com.example.demodtoonetomany.entity.User;
import com.example.demodtoonetomany.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDTOService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<UserDTO> getAllUsersLocation(){
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    private UserDTO convertEntityToDto(User user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
//        UserDTO userDTO = new UserDTO();
//        userDTO = modelMapper.map(user,UserDTO.class);
//        return userDTO;

        PropertyMap<User, UserDTO> personMap = new PropertyMap<User, UserDTO>() {
            protected void configure() {
                map().setLocation(source.getLocations().stream().map(x -> modelMapper.map(x,LocationDto.class)).collect(Collectors.toList()));
            }
        };

        modelMapper.addMappings(personMap);

        UserDTO userDTO = new UserDTO();
        userDTO = modelMapper.map(user,UserDTO.class);
        return userDTO;

    }
}
