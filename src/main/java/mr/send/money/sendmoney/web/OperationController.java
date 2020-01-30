package mr.send.money.sendmoney.web;

import mr.send.money.sendmoney.entites.Transaction;
import mr.send.money.sendmoney.secure.payload.response.MessageResponse;
import mr.send.money.sendmoney.service.imp.OperationServiceImp;
import mr.send.money.sendmoney.service.util.UserDto.CreditOrDebitForm;
import mr.send.money.sendmoney.service.util.UserDto.SendingForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping( "/operations" )
public class OperationController {

    private OperationServiceImp operationServiceImp;

    public OperationController(OperationServiceImp operationServiceImp) {
        this.operationServiceImp = operationServiceImp;
    }

    @PostMapping( "/credit" )
    public ResponseEntity<?> credit(@RequestBody @Valid @NotNull CreditOrDebitForm creditOrDebitForm) {

        Transaction tx = operationServiceImp.creditAccount(creditOrDebitForm);
        if (tx == null)
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: can not credit account !"));

        return ResponseEntity.ok().body(tx);
    }

    @PostMapping( "/debit" )
    public ResponseEntity<?> debit(@RequestBody @Valid @NotNull CreditOrDebitForm creditOrDebitForm) {
        Transaction tx = operationServiceImp.debitAccount(creditOrDebitForm);
        if (tx == null)
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: can not debit your account !"));

        return ResponseEntity.ok().body(tx);
    }

    @PostMapping( "/send" )
    public ResponseEntity<?> send(@RequestBody @Valid @NotNull SendingForm sendingForm) {
        Transaction tx = operationServiceImp.sendMoney(sendingForm);
        if (tx == null)
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: can not send  any things !"));

        return ResponseEntity.ok().body(tx);
    }

}
