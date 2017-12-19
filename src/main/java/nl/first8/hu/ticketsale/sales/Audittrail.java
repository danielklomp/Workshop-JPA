package nl.first8.hu.ticketsale.sales;

import lombok.Data;
import lombok.NoArgsConstructor;
import nl.first8.hu.ticketsale.registration.Account;
import nl.first8.hu.ticketsale.venue.Concert;

import javax.persistence.*;

/**
 * Created by danie on 19-12-2017.
 */

@Entity
@Data
public class Audittrail {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name="sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    public Audittrail(Sale sale, Account account) {
        this.sale = sale;
        this.account = account;
    }
}
