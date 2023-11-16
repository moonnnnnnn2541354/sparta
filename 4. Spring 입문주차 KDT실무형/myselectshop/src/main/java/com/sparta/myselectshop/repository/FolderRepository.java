package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.entity.Folder;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;

public interface FolderRepository extends JpaAttributeConverter<Folder,Long> {

}
