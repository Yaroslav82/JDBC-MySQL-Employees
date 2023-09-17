package org.example.app.services;

import org.example.app.entities.Position;
import org.example.app.repositories.BaseRepository;
import org.example.app.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class PositionOperationService extends OperationService<Position> {

    public PositionOperationService(BaseRepository<Position> repository) {
        super(repository);
    }

    @Override
    public String read() {
        return super.read(Constants.TABLE_POSITIONS);
    }

    @Override
    protected Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (data[0].isEmpty())
            errors.put("name", Constants.INPUT_REQ_MSG);

        return errors;
    }

    @Override
    protected Position convertData(String[] data) {
        Position position = new Position();

        position.setName(data[0]);

        return position;
    }
}
