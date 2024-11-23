    package com.BillGenrationsSystem.BillManagementSystem.EntityModels;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;

    @Entity
    public class PaymentAPI {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String apiKey;
        private String status;

        // getters and setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public PaymentAPI() {
        }

        public PaymentAPI(Long id, String apiKey, String status) {
            this.id = id;
            this.apiKey = apiKey;
            this.status = status;
        }
    }