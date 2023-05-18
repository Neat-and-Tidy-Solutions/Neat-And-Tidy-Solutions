package Neat.and.Tidy.Solutions.cleaning.service.app.data.models;

import java.io.File;

public class Notification {
    private String id;
    private String subject;
    private String body;
    private Customer recipient;
    private Admin sender;
    private File attachment;
}
