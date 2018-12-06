printf (1..10).to_a #create range from 1 to 10
print "\n\n"

print (1...10).to_a #create range from 1 to 10
print "\n\n"

print ('a'...'l').to_a #acccept character
print "\n\n"

print ('aba'...'abr').to_a #acccept string
print "\n\n"

print ('aba'...'abr').min #min method
print "\n\n"

print ('aba'...'abr').max #max method
print "\n\n"

print ('aba'...'abr').include?('aba')#include method
print "\n\n"

print ('aba'...'abr').reject {|element| element < 'abf'} #reject method
print "\n\n"

('aba'...'abr').each {|element| print element + ', '} #each method
print "\n\n"

print (1..10)===7 #value within ranges method
print "\n\n"