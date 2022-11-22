package com.contact.application.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {



   @ExceptionHandler(value=NoDuplicateEmailIdException.class)
    public ResponseEntity<ExceptionResponce> handleDuplicateEmailId(NoDuplicateEmailIdException e) {
        ExceptionResponce response = new ExceptionResponce();
        response.setErrorMsg("CONFLICT");
        response.setErrorCode(e.getMessage());
        response.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
   
   
   @ExceptionHandler(value=InvalidEmailIdException.class)
   public ResponseEntity<ExceptionResponce> InvalidEmailId(InvalidEmailIdException e) {
       ExceptionResponce response = new ExceptionResponce();
       response.setErrorMsg("CONFLICT");
       response.setErrorCode(e.getMessage());
       response.setTimeStamp(LocalDateTime.now());
       return new ResponseEntity<>(response, HttpStatus.CONFLICT);
       }
   
   
   
   @ExceptionHandler(value=InvalidContactNumberException.class)
   public ResponseEntity<ExceptionResponce> InvalidContactNumber(InvalidContactNumberException e) {
       ExceptionResponce response = new ExceptionResponce();
       response.setErrorMsg("CONFLICT");
       response.setErrorCode(e.getMessage());
       response.setTimeStamp(LocalDateTime.now());
       return new ResponseEntity<>(response, HttpStatus.CONFLICT);
       }
   
   
   
   @ExceptionHandler(value=WrongLoginException.class)
   public ResponseEntity<ExceptionResponce> WrongLogin(WrongLoginException e) {
       ExceptionResponce response = new ExceptionResponce();
       response.setErrorMsg("CONFLICT");
       response.setErrorCode(e.getMessage());
       response.setTimeStamp(LocalDateTime.now());
       return new ResponseEntity<>(response, HttpStatus.CONFLICT);
       }
   
   
   @ExceptionHandler(value=UserNotPresentException.class)
   public ResponseEntity<ExceptionResponce> UserNotPresent(UserNotPresentException e) {
       ExceptionResponce response = new ExceptionResponce();
       response.setErrorMsg("CONFLICT");
       response.setErrorCode(e.getMessage());
       response.setTimeStamp(LocalDateTime.now());
       return new ResponseEntity<>(response, HttpStatus.CONFLICT);
       }
   
   @ExceptionHandler(value=InvalidPasswordExeption.class)
   public ResponseEntity<ExceptionResponce> InvalidPassword(InvalidPasswordExeption e) {
       ExceptionResponce response = new ExceptionResponce();
       response.setErrorMsg(e.getMessage());
       response.setErrorCode("CONFLICT");
       response.setTimeStamp(LocalDateTime.now());
       return new ResponseEntity<>(response, HttpStatus.CONFLICT);
       }
   
   @ExceptionHandler(value=DuplicatePhoneNumberException.class)
   public ResponseEntity<ExceptionResponce> DuplicatePhoneNumber(DuplicatePhoneNumberException e) {
       ExceptionResponce response = new ExceptionResponce();
       response.setErrorMsg(e.getMessage());
       response.setErrorCode("CONFLICT");
       response.setTimeStamp(LocalDateTime.now());
       return new ResponseEntity<>(response, HttpStatus.CONFLICT);
       }
   }
