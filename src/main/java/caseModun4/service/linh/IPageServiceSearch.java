package caseModun4.service.linh;

import caseModun4.model.Page;

import java.util.List;

public interface IPageServiceSearch extends ICRUD_Service<Page> {
    List<Page> findByText(String text);
}
