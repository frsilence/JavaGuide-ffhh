package cn.ffhh.bookstore.dao;

import java.util.List;
import java.util.Set;

/**
 * 公共DAO接口，定义通用 的CUDR操作标准
 * @author yfzhao
 *
 * @param <K> 表示要操作的主键类型，由子接口实现
 * @param <V> 表示要操作的VO类，由子接口实现
 */
public interface IBookstoreDao<K,V> {
	/**
	 * 	数据增加操作
	 * @param vo 是V类的对象数据
	 * @return 数据保存成功返回true，否则返回false
	 */
	public boolean doCreate(V vo);
	/**
	 * 	数据更新操作，此方法是根据数据的id进行全部字段的更新
	 * @param vo 包含了要修改的信息，必须提供id信息
	 * @return	更新成功则返回true，否则返回false
	 */
	public boolean doUpdate(V vo);
	/**
	 * 	此操作为批量操作，根据Set集合提供的id进行删除
	 * @param ids 包含了所有要删除的数据的id，不能存在重复
	 * @return 批量删除成功则返回true（删除的个数要和提供的id个数一致），负责返回false
	 */
	public boolean doRemoveBatch(Set<K> ids);
	/**
	 * 	此操作是根据所提供的id进行数据查询
	 * @param id 指定要搜索的id
	 * @return 返回被搜索到的V对象数据，若不存在则返回null
	 */
	public V findById(K id);
	/**
	 * 此操作是查询所有数据，并以List集合的形式返回数据
	 * @return 如果表中有数据则所有数据封装成V对象后再用List集合返回
	 */
	public List<V> findAll();
	/**
	 * 	分页进行模糊查询，查询结果以List集合返回
	 * @param currentPage 当前页码
	 * @param lineSize 每页所显示的数据量
	 * @param column 进行模糊查询的字段
	 * @param keyWord	进行模糊查询的关键字
	 * @return	若查询到符合要求的数据会封装为Emp对象数据然后利用List集合返回
	 */
	public List<V> findAllSplit(Integer currentPage,Integer lineSize,String column,String keyWord);
	/**
	 * 	进行模糊查询数据量的统计，若有数据则返回数据个数
	 * @param column 要进行模糊查询的数据列
	 * @param keyWord 进行查询的关键字
	 * @return 返回符合条件的数据数量
	 */
	public Integer getAllCount(String column,String keyWord);
}
