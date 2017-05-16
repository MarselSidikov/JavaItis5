package ru.itis.main.utils;

import ru.itis.main.generators.IdGenerator;
import ru.itis.main.mapper.RowMapper;
import ru.itis.main.models.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileDaoQueryTemplateImpl implements FileDaoQueryTemplate {
    IdGenerator idGenerator;

    public FileDaoQueryTemplateImpl(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public <T> List<T> findAll(String fileName, RowMapper<T> mapper) {
        try {
            // создаем список моделей, которые мы вытащим из файла
            ArrayList<T> models = new ArrayList<>();
            // создаем читалку из файла
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            // считали первую строку
            String currentModel = reader.readLine();
            // пока строка считанная не нулевая
            while (currentModel != null) {
                // отображаем строку в объект
                T model = mapper.mapRow(currentModel);
                // сохраняем модель в список
                models.add(model);
                // считываем следующую строку
                currentModel = reader.readLine();
            }
            reader.close();
            return models;
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return new ArrayList<T>();
    }


    @Override
    public <T> int save(String fileName, T model) {
        // проверяем, действительно ли входная модель является
        // моделью - есть возможность проставить id
        if (model instanceof Model) {
            //Преобразуем нашу модель в интерфейс
            Model castedModel = (Model) model;
            // проставляем id
            castedModel.setId(idGenerator.generateId());
            // сконвертировали в строку
            String modelDataAsString = castedModel.toString();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                // сохранили
                writer.write(modelDataAsString);
                writer.newLine();
                writer.close();
                return castedModel.getId();
            } catch (IOException e) {
                System.err.println("IO Exception");
            }
        }
        throw new IllegalArgumentException("Model is not implement Model interface");

    }

    @Override
    public <T> void update(String fileName, T model) {
        if (model instanceof Model) {
            int id = ((Model) model).getId();
            List<String> models = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String currentModel = reader.readLine();
                while (currentModel != null) {
                    String currentModelAsArray[] = currentModel.split(" ");
                    int modelId = Integer.parseInt(currentModelAsArray[0]);
                    if (modelId == id) {
                        models.add(model.toString());
                    } else {
                        models.add(currentModel);
                    }
                    currentModel = reader.readLine();
                    // переписываем наш файл
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    for (int i = 0; i < models.size(); i++) {
                        writer.write(models.get(i));
                        writer.newLine();
                    }
                    writer.close();
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found Exception!!!");
            } catch (IOException e) {
                System.err.println("IO Exception!!!");
            }

        } else {
            throw new IllegalArgumentException("This model is not implement Model interface!");
        }
    }

    @Override
    public <T> List<T> findByValue(String fileName, RowMapper<T> mapper, int valueColumn, Object value) {
        // создаем список для моделей
        List<T> models = new ArrayList<>();
        try {
            // создаем читалку
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            // считали текущую модель как строку
            String currentModelAsString = reader.readLine();
            // пока есть что считывать
            while (currentModelAsString != null) {
                Object castedValue = null;
                // разбили строку на массив по пробелу
                String currentModelAsArray[] = currentModelAsString.split(" ");
                // достаем значение текущей строки в позиции valueColumn
                String rowValue = currentModelAsArray[valueColumn];
                // ПРЕОБРАЗОВАНИЯ
                if (value.getClass().getName().equals("java.lang.String")) {
                    castedValue = String.valueOf(rowValue);
                } else if (value.getClass().getName().equals("java.lang.Integer")) {
                    castedValue = Integer.parseInt(rowValue);
                } else if (value.getClass().getName().equals("java.lang.Double")) {
                    castedValue = Double.parseDouble(rowValue);
                } else if (value.getClass().getName().equals("java.lang.Boolean")) {
                    castedValue = Boolean.valueOf(rowValue);
                }
                // проверяем, соответсвтует ли значение тому, которое нам нужно
                if (value.equals(castedValue)) {
                    // если соответствует, преобразуем в модель
                    T model = mapper.mapRow(currentModelAsString);
                    // кидаем в список
                    models.add(model);
                }
                currentModelAsString = reader.readLine();

            }

            return models;
        } catch (FileNotFoundException e) {
            System.err.println("File not found Exception");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }

        return models;
    }

    @Override
    public void deleteByValue(String fileName, int valueColumn, Object value) {
        try {
            List<String> models = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String current = reader.readLine();
            value = value.toString();
            int finded = 0; // счетчик, что бы больше одного не удалить
            while (current != null) {
                String currenAsArray[] = current.split(" ");
                String needElement = currenAsArray[valueColumn];
                if (needElement.equals(value) && finded == 0) {
                    finded++;
                } else {
                    models.add(current);
                }
                current = reader.readLine();
            }
            // переписываем наш файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < models.size(); i++) {
                writer.write(models.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not Found Exception!!");
        } catch (IOException e) {
            System.err.println("IO Exception =(");
        }


    }
}
