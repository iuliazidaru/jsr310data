jsr310data
==========


The project contains Sring converters for jsr310 classes. It is not currently added in maven repository, so, it must be compiled from sources.

Usage

```<dependency>
			<groupId>ro.izi.jsr310</groupId>
			<artifactId>data</artifactId>
			<version>0.0.1-SNAPSHOT</version>
</dependency>
```
Use it in mongo configuration:
```
@Configuration
@ConfigurationProperties
public class MongoPersistenceConfiguration extends AbstractMongoConfiguration {
      @Value( "${mongo.host}" )  
      private String mongoHost;
      
      @Value( "${mongo.db}" )
      private String mongoDB;
    
	  @Bean
	  public Mongo mongo() throws Exception {
	    return new Mongo(mongoHost);
	  }

	  @Override
	  public String getDatabaseName() {
	    return mongoDB;
	  }

	  @Override
	  public String getMappingBasePackage() {
	    return "ro.izi.mypackage.domain";
	  }

	  @Bean
	  @Override
	  public CustomConversions customConversions() {
	    List<Converter<?, ?>> converterList = new ArrayList<Converter<?, ?>>();
	    converterList.add(new InstantToLongConverter());
	    converterList.add(new LongToInstantConverter());
	    converterList.add(new LocalDateToStringConverter());
	    converterList.add(new StringToLocalDateConverter());
	    
	    return new CustomConversions(converterList);
	  }

}
```

Use it in repository unit tests:
```
public class MongoMyRepositoryTest {

	MongoOperations mongoOperations;

    
    MongoMyRepository mongoTodoRepository = new MongoMtRepository();
    
    @SuppressWarnings("deprecation")
    @Before
    public void setup() throws UnknownHostException{
    	MongoDbFactory factory = new SimpleMongoDbFactory(new Mongo(), "unittests_priorities");
    	
    	CustomConversions conversions = new CustomConversions(Arrays.asList(new LocalDateToStringConverter(), new StringToLocalDateConverter()));
    	MongoMappingContext context = new MongoMappingContext();
    	context.setInitialEntitySet(new HashSet<Class<?>>(Arrays.asList(Todo.class)));
    	context.setSimpleTypeHolder(conversions.getSimpleTypeHolder());
    	context.initialize();
    	MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(factory), context);
    	converter.setCustomConversions(conversions);
    	converter.afterPropertiesSet();
    	
    	mongoOperations = new MongoTemplate(factory, converter);
      mongoMyRepository.setMongoOperations(mongoOperations);
    }
   ``` 
