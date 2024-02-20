package repository;

public class Payment {
    String id;
    Long userId;
    PaymentMethod method;
    PaymentDetails details;
    boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public PaymentDetails getDetails() {
        return details;
    }

    public void setDetails(PaymentDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", method=" + method +
                ", details=" + details +
                ", success=" + success +
                '}';
    }
}
