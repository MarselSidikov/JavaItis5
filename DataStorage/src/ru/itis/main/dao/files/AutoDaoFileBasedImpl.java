package ru.itis.main.dao.files;

import ru.itis.main.dao.AutoDao;
import ru.itis.main.exception.AutoNotFoundException;
import ru.itis.main.mapper.RowMapper;
import ru.itis.main.models.Auto;
import ru.itis.main.models.AutoBuilder;
import ru.itis.main.models.User;
import ru.itis.main.utils.FileDaoQueryTemplate;

import java.util.ArrayList;
import java.util.List;


public class AutoDaoFileBasedImpl implements AutoDao {
    private String fileName;
    private FileDaoQueryTemplate template;

    public AutoDaoFileBasedImpl(String fileName, FileDaoQueryTemplate template) {
        this.fileName = fileName;
        this.template = template;
    }

    private RowMapper<Auto> autoRowMapper = new RowMapper<Auto>() {
        @Override
        public Auto mapRow(String row) {
            String autoDataAsArray[] = row.split(" ");
          //  Auto auto = new AutoBuilder().setId(Integer.parseInt(autoDataAsArray[0])).setModel(autoDataAsArray[1]).setColor(autoDataAsArray[2]).setCarMileage(Double.parseDouble(autoDataAsArray[3])).setUsed(Boolean.valueOf(autoDataAsArray[4])).setIdOwner(Integer.parseInt(autoDataAsArray[5])).createAuto();
            return null;
        }
    };

    @Override
    public Auto find(int id) {
        List<Auto> autos = template.findByValue(fileName, autoRowMapper, 0, id);
        if (autos.size() == 0) {
            throw new AutoNotFoundException("Auto not found");
        } else {
            return autos.get(0);
        }
    }

    @Override
    public int save(Auto auto) {
        return template.save(fileName, auto);
    }

    @Override
    public void delete(int id) {
        template.deleteByValue(fileName, 0, id);
    }

    @Override
    public void update(Auto auto) {
        template.update(fileName, auto);
    }

    @Override
    public List<Auto> findAll() {
        return template.findAll(fileName, autoRowMapper);
    }

    @Override
    public List<Auto> findAllByUsed() {
        List<Auto> autos = template.findAll(fileName, autoRowMapper);
        List<Auto> usedAutos = new ArrayList<>();
        for (int i = 0; i < autos.size(); i++) {
            /*
            if (autos.get(i).isUsed() || autos.get(i).getCarMileage() > 10) {
                usedAutos.add(autos.get(i));
            }*/
        }
        return usedAutos;
    }

    @Override
    public List<Auto> findAllAutoByOwner(User user) {
        int idUser = user.getId();
        List<Auto> autos = template.findByValue(fileName, autoRowMapper, 5, idUser);
        if (autos.size() > 0) {
            return autos;
        }
        throw new AutoNotFoundException("Auto not found");
    }
}
