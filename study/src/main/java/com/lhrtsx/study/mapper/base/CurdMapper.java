package com.lhrtsx.study.mapper.base;

public interface CurdMapper<T> extends InsertMapper<T>, UpdateMApper<T>, DeleteMapper<T>, SelectMapper<T> {
    default int updateByPrimaryKeyWithVersionSelective(T t) throws Exception {
        int result = this.updateByPrimaryKeySelective(t);
        if (result == 0) {
            throw new Exception("更新失败-该数据已被他人修改!");
        } else {
            return result;
        }
    }

    default int updateByPrimaryKeyWithVersion(T t) throws Exception {
        int result = this.updateByPrimaryKey(t);
        if (result == 0) {
            throw new Exception("更新失败-该数据已被他人修改!");
        } else {
            return result;
        }
    }

    default int updateByExampleWithVersionSelective(T t, Object example) throws Exception {
        int result = this.updateByExampleSelective(t, example);
        if (result == 0) {
            throw new Exception("更新失败-该数据已被他人修改!");
        } else {
            return result;
        }
    }


    default int deleteByPrimaryKeyWithVersion(T t) throws Exception {
        int result = this.deleteByPrimaryKey(t);
        if (result == 0) {
            throw new Exception("删除失败-该数据已被他人修改!");
        } else {
            return result;
        }
    }

    default int deleteWithVersion(T t) throws Exception {
        int result = this.delete(t);
        if (result == 0) {
            throw new Exception("删除失败-该数据已被他人修改!");
        } else {
            return result;
        }
    }
}
