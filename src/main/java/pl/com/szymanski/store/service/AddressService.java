package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Address;

@Service
public interface AddressService {

    void saveAddress(Address address);
}
