package com.bookloverbackend.bookloverbackend.mapper;

import com.bookloverbackend.bookloverbackend.dto.BookDTO;
import com.bookloverbackend.bookloverbackend.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toBookDTO(Book book);
}
