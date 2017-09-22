from string import Template
import os

def main():
    number = raw_input('Enter problem number: ')
    link = raw_input('Enter problem url: ')
    problem = link.split('/')[-2]

    title = problem.replace('-', ' ').title()

    # Write README.md
    template = Template("""
    
### $No. $Title

[Lintcode](http://lintcode.com/en/problem/$tag/) 
| [Online Solution](http://jiuzhang.com/solutions/$tag/)
| [Java Solution]($No.$tag.java) 
| [Cpp Solution]($No.$tag.cpp)
| [Blog](http://blog.liuk.ai/$No-$tag/)

    """)

    post_template = Template("""
$No. $Title
#### Problem  
[Practice on Lintcode](http://lintcode.com/en/problem/$tag/)



**Example**  



#### Solution  
Time complexity `O(n)`

*Implementation*
```language-java line-numbers

```

*Implementation Note*


    """)

    try:
        f = open('README.md', 'a+')
    except:
        f = open('README.md', 'w')

    f.write(template.substitute({'No': number, 'tag': problem, 'Title': title}))
    f.write(post_template.substitute({'No': number, 'tag': problem, 'Title': title}))
    f.close()


    # Create files
    pwd = os.getcwd()
    fh = open('%s/%s.%s.java' % (pwd, number, problem), 'w')
    fh.close()

    fh = open('%s/%s.%s.cpp' % (pwd, number, problem), 'w')
    fh.close()

if __name__ == "__main__":
    main()