package com.offlinedata.Resonse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abc on 19-06-17.
 */
public class ListResoponse {
    @SerializedName("trainer_id")
    @Expose
    private String trainerId;
    @SerializedName("client_id")
    @Expose
    private String clientId;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("homework")
    @Expose
    private String homework;
    @SerializedName("profile_pic")
    @Expose
    private String profilePic;
    @SerializedName("first_name")
    @Expose
    private String firstName;

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
