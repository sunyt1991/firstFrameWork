package util;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * 实现JAVA对象与JSON相互转换
 * 
 */
public class JacksonUtil extends ObjectMapper {

	private static final long serialVersionUID = 27476334584914123L;

	public JacksonUtil() {
	}

	/**
	 * 带JsonInclude.Include的构造方法
	 * 
	 * @param inclusion
	 *          将Bean输出到JSON时,需要包含哪些属性(排除那些属性)
	 */
	public JacksonUtil(JsonInclude.Include inclusion) {
		setSerializationInclusion(inclusion);
	}



	/**
	 * 带是否时间格式化的构造方法
	 * 
	 * @param dateFormat
	 *          格式如:yyyy-MM-dd
	 * 
	 */
	public JacksonUtil(String dateFormat) {
		setDateFormat(new SimpleDateFormat(dateFormat));
	}


	/**
	 * <ul>
	 * 输出JSON时,仅包含哪些字段
	 * <li>mapper.setIncludeFilter(...)</li>
	 * <li>在要过滤的实体类上添加:@JsonFilter("includeFilter")</li>
	 * </ul>
	 */
	public void setIncludeFilter(String... includes) {
		SimpleFilterProvider includeFilter = new SimpleFilterProvider();
		includeFilter.addFilter("includeFilter", SimpleBeanPropertyFilter.filterOutAllExcept(includes));
		this.setFilters(includeFilter);
	}

	/**
	 * 输出JSON时,排除哪些字段
	 */
	public void setExcludeFilter(String... excludes) {
		SimpleFilterProvider excludeFilter = new SimpleFilterProvider();
		excludeFilter.addFilter("excludeFilter", SimpleBeanPropertyFilter.serializeAllExcept(excludes));
		this.setFilters(excludeFilter);
	}

	/**
	 * <ul>
	 * 支持"嵌套"过滤
	 * <li>定义一个接口或类,在该[接口/类]上添加@JsonIgnoreProperties("要动态过滤掉的属性")</li>
	 * <li></li>
	 * <li>target:要过滤的实体类,如:Order.class</li>
	 * <li>mixinSource:上面定义的接口或类</li>
	 * <li></li>
	 * <li>如果不仅仅为主对象混入过滤,同时为关联对象混入过滤</li>
	 * <li>如:Order(主对象),Member(关联对象)均混入过滤</li>
	 * <li>(主对象,关联对象)均起作用---"嵌套"过滤</li>
	 * <li></li>
	 * <li>注:与@JsonBackReference有冲突</li>
	 * </ul>
	 * 
	 * @see com.fasterxml.jackson.databind.ObjectMapper#addMixInAnnotations
	 */
	public void addMixIn(Class<?> target, Class<?> mixinSource) {
		this.addMixInAnnotations(target, mixinSource);
	}

	/**
	 * 把Object转化为JSON字符串
	 * 
	 * @param object
	 *          can be pojo entity,list,map etc.
	 */
	public String toJson(Object object) {
		try {
			return this.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("对象转化为JSON时,解析对象错误");
		}
	}

	/**
	 * JSON转List
	 * 
	 * @param json
	 *          json字符串
	 * 
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> toList(String json) {
		try {
			return this.readValue(json, List.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("解析json错误");
		}
	}

	/**
	 * json转换为java对象
	 * 
	 * @param json
	 *          字符串
	 * @param clazz
	 *          对象的class
	 * @return 返回对象
	 */
	public <T> T toObject(String json, Class<T> clazz) {
		try {
			return this.readValue(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JSON转化为对象时,解析JSON错误");
		}
	}
}
