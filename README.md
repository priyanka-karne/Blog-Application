# Blog-Application
Its a blog application where one user can blog there thoughts on it and other users can read and comment on that


for pagination we use spring boot spring data jpa method pagable from import org.springframework.data.domain.Pageable;
example/*
int pageSize=5;
		int pageNumber=1;
		Pageable p=PageRequest.of(pageNumber, pageSize);
		
	      Page<Post> pagePost=this.postRepo.findAll(p);
	      List<Post> post=pagePost.getContent();
        
        */
