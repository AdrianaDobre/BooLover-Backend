package com.bookloverbackend.bookloverbackend.mapper;

import com.bookloverbackend.bookloverbackend.dto.BookDTO;
import com.bookloverbackend.bookloverbackend.dto.ReviewDTO;
import com.bookloverbackend.bookloverbackend.model.Book;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toBookDTO(Book book, List<ReviewDTO> reviews, String email);
}
