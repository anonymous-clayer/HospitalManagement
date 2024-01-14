package com.dev.HospitalManagement.Service;

import com.dev.HospitalManagement.Entity.Request;
import com.dev.HospitalManagement.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public void addRequest(Request request){
        requestRepository.save(request);
    }

    public Request getRequestById(Long requestId) {
        return requestRepository.findById(requestId).orElse(null);
    }

    public void acceptRequest(Long requestId, String requestDesc) {
        Request request = getRequestById(requestId);
        if (request != null) {
            request.setRequest(requestDesc);
            requestRepository.save(request);
        }
        // Note: You might want to add logging or handle the case where the request is not found.
    }

}
