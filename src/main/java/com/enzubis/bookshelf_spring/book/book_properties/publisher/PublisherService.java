package com.enzubis.bookshelf_spring.book.book_properties.publisher;

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

    public Publisher addPublisherId(Publisher publisher){
        Optional<Publisher> publisherOptional = publisherRepository.findPublisherByPublisher(publisher);

        if(publisherOptional.isPresent()){
            return publisherOptional.get();
        }

        Publisher newPublisher = new Publisher(publisher.getName());
        return publisherRepository.save(newPublisher);
    }
}
