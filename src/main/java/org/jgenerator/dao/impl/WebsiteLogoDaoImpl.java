package org.jgenerator.dao.impl;
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.WebsiteLogoDao;
import org.jgenerator.model.WebsiteLogo;
import org.springframework.stereotype.Repository;

@Repository
public class WebsiteLogoDaoImpl extends BaseDaoImpl<WebsiteLogo, Integer> implements WebsiteLogoDao{
}