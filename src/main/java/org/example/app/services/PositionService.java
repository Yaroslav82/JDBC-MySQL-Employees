package org.example.app.services;

import org.example.app.controllers.OperationController;
import org.example.app.entities.Position;
import org.example.app.repositories.BaseRepository;
import org.example.app.repositories.PositionRepository;
import org.example.app.views.CreateView;
import org.example.app.views.PositionCreateView;

public class PositionService extends BaseService<Position> {

    @Override
    protected OperationController<Position> getController() {
        CreateView view = new PositionCreateView();
        BaseRepository<Position> repository = new PositionRepository();
        OperationService<Position> service = new PositionOperationService(repository);
        return new OperationController<>(service, view);
    }

}
