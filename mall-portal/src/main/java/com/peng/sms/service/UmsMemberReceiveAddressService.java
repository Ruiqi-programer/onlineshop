package com.peng.sms.service;

import com.peng.sms.model.UmsMemberReceiveAddress;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User address management service
 */
public interface UmsMemberReceiveAddressService {

    /**
     * Add a new delivery address
     *
     * @param address the delivery address to add
     * @return number of records added
     */
    int add(UmsMemberReceiveAddress address);

    /**
     * Delete a delivery address
     *
     * @param id the ID of the address
     * @return number of records deleted
     */
    int delete(Long id);

    /**
     * Update a delivery address
     *
     * @param id      the ID of the address to update
     * @param address the updated address information
     * @return number of records updated
     */
    @Transactional
    int update(Long id, UmsMemberReceiveAddress address);

    /**
     * List all delivery addresses of the current user
     *
     * @return list of addresses
     */
    List<UmsMemberReceiveAddress> list();

    /**
     * Get details of a specific address
     *
     * @param id the address ID
     * @return the address details
     */
    UmsMemberReceiveAddress getItem(Long id);
}
