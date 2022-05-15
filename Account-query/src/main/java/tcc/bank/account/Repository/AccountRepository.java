package tcc.bank.account.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tcc.bank.account.Model.AccountModel;

public interface AccountRepository extends MongoRepository<AccountModel, Integer> {
}
