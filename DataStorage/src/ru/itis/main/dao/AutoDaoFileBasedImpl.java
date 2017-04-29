package ru.itis.main.dao;

import ru.itis.main.models.Auto;
import ru.itis.main.utils.FileDaoQueryTemplate;

import java.util.List;

/**
 * 27.04.2017
 * AutoDaoFileBasedImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class AutoDaoFileBasedImpl implements AutoDao {

    private String fileName;
    private FileDaoQueryTemplate template;

    public AutoDaoFileBasedImpl(String fileName, FileDaoQueryTemplate template) {
        this.fileName = fileName;
        this.template = template;
    }

    @Override
    public Auto find(int id) {
        return null;
    }

    @Override
    public int save(Auto model) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Auto model) {

    }

    @Override
    public List<Auto> findAll() {
        return null;
    }

    @Override
    public List<Auto> findAllByUsed(boolean isUsed) {
        return null;
    }

    @Override
    public List<Auto> findAllAutoByUserId(int userId) {
        return null;
    }
}
