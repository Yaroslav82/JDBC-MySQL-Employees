package org.example.app.services;

import org.example.app.exceptions.CreateException;
import org.example.app.repositories.BaseRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.StringFormatter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class OperationService<T> implements CreateService, ReadService {

    private final BaseRepository<T> repository;

    public OperationService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public String create(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException e) {
                return e.getErrors(errors);
            }
        }

        return repository.create(convertData(data));
    }

    protected String read(String tableName) {

        List<T> list = repository.findAll(tableName);

        if (list != null) {

            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();

                list.forEach(pos -> stringBuilder.append(count.incrementAndGet()).append(") ").append(pos).append("\n"));

                return "\n_________ " + StringFormatter.capitalize(tableName) + " _________\n" + stringBuilder;
            }
        }
        return Constants.DATA_ABSENT_MSG;
    }

    protected abstract Map<String, String> validateData(String[] data);

    protected abstract T convertData(String[] data);
}
