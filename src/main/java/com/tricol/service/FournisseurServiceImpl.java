package com.tricol.service;
import org.springframework.stereotype.Service;


@Service
public class FournisseurServiceImpl implements FournisseurService {

    @Override
    public String getMessage(){
        return "hi";
    }
}
