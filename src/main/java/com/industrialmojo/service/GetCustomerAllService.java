package com.industrialmojo.service;

import com.industrialmojo.dto.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class GetCustomerAllService implements GetCustomerService {

    private final GetCustomerService customerOverService;
    private final GetCustomerService customerUnderService;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public GetCustomerAllService(GetCustomerOverService customerOverService,
                                 GetCustomerUnderService customerUnderService) {
        this.customerOverService = customerOverService;
        this.customerUnderService = customerUnderService;
    }

    public List<Customer> getCustomers() {

        Future<List<Customer>> future1 = getOverCustomers();
        Future<List<Customer>> future2 = getUnderCustomers();

        try {
            while (!(future1.isDone() && future2.isDone())) {
                System.out.println(
                        String.format(
                                "future1 is %s and future2 is %s",
                                future1.isDone() ? "done" : "not done",
                                future2.isDone() ? "done" : "not done"
                        )
                );
                Thread.sleep(300);
            }

            List<Customer> result1 = future1.get();
            List<Customer> result2 = future2.get();
            result1.addAll(result2);
            return result1;
        } catch (Throwable t) {
            System.out.println("EXCEPTION THROWN");
        }
        return null;
    }

    private Future<List<Customer>> getOverCustomers() {
        return executorService.submit(() -> {
            Thread.sleep(10000);
            return customerOverService.getCustomers();
        });
    }

    private Future<List<Customer>> getUnderCustomers() {
        return executorService.submit(() -> {
            Thread.sleep(1000);
            return customerUnderService.getCustomers();
        });
    }
}
