package com.hrajaona.userservice.adapters.in.web;

import com.hrajaona.userservice.application.service.AddressService;
import com.hrajaona.userservice.domain.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/addresses")
public class AddressController {
    private final AddressService addressService;

    @RequestMapping
    public ResponseEntity<List<Address>> getAllAddressByUserId(@RequestParam UUID userId) {
        return ResponseEntity.ok(addressService.getAllAddressByUserId(userId));
    }

    @RequestMapping("/default")
    public ResponseEntity<Address> getDefaultAddressByUserId(@RequestParam UUID userId) {
        return ResponseEntity.ok(addressService.getDefaultAddressByUserId(userId));
    }
}
