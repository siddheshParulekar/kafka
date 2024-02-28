package com.kafaPoc.delcapital.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentReconciliationRequest implements Serializable {


    String utr;
    BigDecimal amount;
    String delLoanId;
}
