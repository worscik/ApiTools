package pl.apidoisender;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.Instant;

public class Request implements Serializable {

    @JsonProperty("clientId")
    private String clientId;
    @JsonProperty("apiKey")
    private String apiKey;
    @JsonProperty("requestTime")
    private Instant requestTime;
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("email")
    private String email;
    @JsonProperty("doubleOptInEmailId")
    private String doubleOptInEmailId;


    private Request(Builder builder) {
        this.clientId = builder.clientId;
        this.apiKey = builder.apiKey;
        this.requestTime = builder.requestTime;
        this.sha = builder.sha;
        this.owner = builder.owner;
        this.email = builder.email;
        this.doubleOptInEmailId = builder.doubleOptInEmailId;
    }


    public static class Builder{
        private String clientId;
        private String apiKey;
        private Instant requestTime;
        private String sha;
        private String owner;
        private String email;
        private String doubleOptInEmailId;

        public Builder withClintId(String clientId) {
            this.clientId = clientId;
            return this;
        }
        public Builder withApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }
        public Builder withRequestTime(Instant requestTime) {
            this.requestTime = requestTime;
            return this;
        }
        public Builder withSha(String sha) {
            this.sha = sha;
            return this;
        }
        public Builder withOwner(String owner) {
            this.owner = owner;
            return this;
        }
        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder withDoubleOptInEmailId(String doubleOptInEmailId) {
            this.doubleOptInEmailId = doubleOptInEmailId;
            return this;
        }

        public Request build(){
            return new Request(this);
        }


    }

    @Override
    public String toString() {
        return "Request{" +
                "clientId='" + clientId + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", requestTime=" + requestTime +
                ", sha='" + sha + '\'' +
                ", owner='" + owner + '\'' +
                ", email='" + email + '\'' +
                ", doubleOptInEmailId='" + doubleOptInEmailId + '\'' +
                '}';
    }
}
