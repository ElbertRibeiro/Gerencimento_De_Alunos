from setuptools import setup

setup(
   name='Student-Management-System',
   version='1.0',
   description='A useful module',
   author='Elbert Ribeiro',
   author_email='elbertprofissional@gmail.com',
   #packages=['foo'],  #same as name
   install_requires=['sqlite3', 'wxPython'], #external packages as dependencies
)