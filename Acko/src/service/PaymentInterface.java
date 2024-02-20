package service;

import repository.Payment;
import repository.PaymentDetails;
import repository.User;

public interface PaymentInterface {
     boolean validatePayment(PaymentDetails paymentDetails);
     Payment executePayment(User user, PaymentDetails paymentDetails);
}
