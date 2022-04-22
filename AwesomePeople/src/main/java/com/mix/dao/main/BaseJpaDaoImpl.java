package com.mix.dao.main;


import java.io.Serializable;

import com.annotations.matching.TheBaseDao;
import com.ent.main.AbstractBaseEntity;
import com.ent.main.BaseEntity;

@TheBaseDao
public class BaseJpaDaoImpl<E extends AbstractBaseEntity> extends AbstractBaseJpaDao implements Serializable{


}
