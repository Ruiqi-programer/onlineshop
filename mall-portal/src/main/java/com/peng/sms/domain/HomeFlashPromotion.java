package com.peng.sms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Information of the current flash promotion session on the homepage
 */
@Getter
@Setter
public class HomeFlashPromotion {
    /**
     * Start time of the current flash promotion session
     */
    private Date startTime;
    /**
     * End time of the current flash promotion session
     */
    private Date endTime;

    /**
     * Start time of the next flash promotion session
     */
    private Date nextStartTime;

    /**
     * End time of the next flash promotion session
     */
    private Date nextEndTime;

    /**
     * List of products belonging to this flash promotion
     */
    private List<FlashPromotionProduct> productList;
}
