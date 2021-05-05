# **Control Lights in OpenLab at TUKE**
**(Thesis)**

User can control RGB lights with txt. configuration or elementary speech commands. Simple user interface (web) is in my repository [ControlLights_Web](https://github.com/wictors/ControlLights_Web). It makes possible choose and play some configurations from list. All configurations should be saved in some gitlab repository with correct yml file.

The project uses [YAJCo](https://github.com/kpi-tuke/yajco/wiki#yajco) (Yet Another Java Compiler compiler) as a tool for development and use of DSL. Java is language for definition of language model and its semantics. Language model consists of annotated Java classes and relations between them. The model corresponds to abstract syntax of the language where each class represents a language concept. 

Connection to OpenLab is create via HTTP requests or MQTT. The project also creates SpringBoot server and contains 3 modules. 
- LightsControlLanguage
- LightsControlSpeech
- SpringApi
 
## LightsControlLanguage
First module contains annotated model of DSL, which makes possible control ligths. YAJCo generated language parser based on the annotated model consists of annotated Java classes. This parser is use for parse user input. Input consists of commands of the DSL. Next, modul also contain the connection to OpenLab via HTTP requests or MQTT. System propertie defines type of connection, which is used.

## LightsControlSpeech
Second module also contains model of DSL and class for to hear user speech commands in OpenLab. The model of DSL not makes possible control lights, but defines concrete speech commands. Generated language parser parses speech, which translated to text form in OpenLab and then correct commands are execute. 

## SpringApi
Main module contains main class `Api`. Firstly, it loads default properties and user properties from file, when defines them. Then SpringBoot server is created and started and also is starting to hearing in OpenLab. Module manages data from request. It loads all configurations from GitLab repository and saves them locally. Sends data to first module or receives data from second module. Also receives name of configuration from user interface (web) and plays it.  
