package com.dev.HospitalManagement.Controller;

import com.dev.HospitalManagement.Entity.Request;
import com.dev.HospitalManagement.Service.RequestService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping("/addRequest")
    public ResponseEntity<String> addRequest(@RequestBody Request request){
        try{
            requestService.addRequest(request);
            return new ResponseEntity<>("Request Added Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("There was some Error in adding the Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{requestId}")
    public ResponseEntity<?> getRequestById(@PathVariable Long requestId) {
        Request request = requestService.getRequestById(requestId);
        if (request != null) {
            return new ResponseEntity<>(request, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Request not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{requestId}/{requestDesc}")
    public ResponseEntity<?> acceptRequest(@PathVariable Long requestId, @PathVariable String requestDesc) {
        requestService.acceptRequest(requestId,requestDesc);
        return new ResponseEntity<>("Request accepted", HttpStatus.OK);
    }

}
