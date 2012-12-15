package org.grails.plugins.coffeescript

import org.springframework.core.io.ClassPathResource

class NodeJSCoffeeScriptEngineTests extends grails.test.GrailsUnitTestCase {

    def coffeeScriptEngine

    void setUp() {
        coffeeScriptEngine = new NodeJSCoffeeScriptEngine()
    }

    void testFileCompile() {
        def input, output
        input = (new ClassPathResource('org/grails/plugins/coffeeScript/example.coffee', getClass().classLoader)).file
        def expectedResult = (new ClassPathResource('org/grails/plugins/coffeeScript/example-1.4.0.js', getClass().classLoader)).file
        output = coffeeScriptEngine.compile(input)
        assert output.contains('number = 42;'): "Output $output"
        assertEquals(expectedResult.text, output)
    }

    void testIsOperatingSystemSupported() {
        assert coffeeScriptEngine.isOperatingSystemSupported()
    }

}


