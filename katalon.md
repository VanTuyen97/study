# Katalon
## Web Service Request
### [Handle response]()
1. Get cookies: 
    ```groovy
    String cookie = response.headerFields.get('Set-Cookie').get(0)
    ```
2. Parse String json:
   - To map: 
        <details>

        ```groovy
        String json = '''{'name':'tuyen', 'age':'22'}'''
    
        JsonSlurper slurper = new JsonSlurper()
        Map parsedJson = slurper.parseText(jsonString)
        ```
        </details>

   - To list:
        <details>

        ```groovy
        String json = '''[{'name':'tuyen', 'age':'22'}, {'name':'hoi', 'age':'22'}]'''

        JsonSlurper slurper = new JsonSlurper()
        List parsedJson = slurper.parseText(jsonString)
        ```
    </details>
3. 
