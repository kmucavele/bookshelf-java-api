package com.me.bookshelf_spring.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublisherService {

    final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher addPublisher(Publisher publisher) {
        Optional<Publisher> publisherOptional = publisherRepository.findPublisherByPublisher(publisher.getPublisher());

        if (publisherOptional.isPresent()) {
            return publisherOptional.get();
        }

        Publisher newPublisher = new Publisher(publisher.getPublisher());
        return publisherRepository.save(newPublisher);
    }
}
